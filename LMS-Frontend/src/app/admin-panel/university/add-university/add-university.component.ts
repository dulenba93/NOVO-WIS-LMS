import { Component, OnInit, EventEmitter } from '@angular/core';
import { UniversityService } from 'src/app/services/university-service/university.service';
import { AddressDto } from 'src/app/model/address';
import {FormBuilder, FormGroup} from '@angular/forms';
import { Place } from 'src/app/model/place';
import { MatSelectChange } from '@angular/material';
import { University } from 'src/app/model/university';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-add-university',
  templateUrl: './add-university.component.html',
  styleUrls: ['./add-university.component.scss']
})
export class AddUniversityComponent implements OnInit {

  address: AddressDto[];
  form: FormGroup;
  place: Place;
  country:String;
  university: University = new University();
  address_id:number;

  constructor( private universityService : UniversityService,
               private fb:FormBuilder,
               private snackBar: MatSnackBar) {

                this.form = fb.group({
                  'name': [null],
                  'date' :[null],
                  'rector': [null],
                  'address' :[null],
                  'country' :[null],
                  'city' :[null]
                });
                }


  ngOnInit() {
    //onemogucavamo inpute jer ce vrednosti biti automatski unesene
    this.form.get("city").disable();
    this.form.get("country").disable();

  this.universityService.getAllAddress().subscribe(
    data => {
      this.address = data.map(item =>{
          return{
            id: item.id,
            street: item.street,
            number: item.number,
            placeDto: item.placeDto,
            // country:item.country
          };

      })

    }
  )
  }

  //ovako se dohvata vrednost na promenu mat-select
  setCityCountry($event){
    
    this.form.get("city").setValue($event.placeDto.name);
    this.form.get("country").setValue($event.placeDto.countryDto.name);
    this.university.address.id = $event.id;
  }


   onSubmit(){
     this.university.name = this.form.get("name").value;
     this.university.year = this.form.get("date").value;
      
    console.log( this.university)
    this.universityService.addNewUniversity(this.university).subscribe();
    this.openSnackBar("You have successfully added University", "Close");
   //treba dodati notifikaciju i redirektovati

   }


  
  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 3000,
    });
  }

}
