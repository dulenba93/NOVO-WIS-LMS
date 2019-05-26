import { Component, OnInit } from '@angular/core';
import { UniversityService } from 'src/app/services/university-service/university.service';
import { Address } from 'src/app/model/address';
import {FormBuilder, FormGroup} from '@angular/forms';
import { Place } from 'src/app/model/place';

@Component({
  selector: 'app-add-university',
  templateUrl: './add-university.component.html',
  styleUrls: ['./add-university.component.scss']
})
export class AddUniversityComponent implements OnInit {

  address: Address[];
  form: FormGroup;
  place: Place;
  country:String;

  constructor( private universityService : UniversityService,
               private fb:FormBuilder) {

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

  this.universityService.getAllAddress().subscribe(
    data => {
      this.address = data.map(item =>{
          return{
            id: item.id,
            street: item.street,
            number: item.number,
            place: item.place,
            // country:item.country
          };

      })

    }
  )
  }

  setCityCountry(){
    this.place=this.address[0].place;
    console.log(this.place);
    // this.country=this.address[0].country;
    console.log(this.country);
  }




/*
      this.address = new Address(0,'','');
      let res = data;
      this.address.street = res['street'];
      this.address.id = res['id'];
      this.address.number = res['number'];

      this.address[] = res;
      */
     
     //console.log(this.address.id['street'])
    

}
