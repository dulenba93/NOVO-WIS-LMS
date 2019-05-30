import { Component, OnInit } from '@angular/core';
import { FormControl, FormBuilder, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import { AddressService } from 'src/app/services/address-service/address.service';
import { MatSnackBar } from '@angular/material';
import { Place } from 'src/app/model/place';
import { Capability } from 'protractor';
import { Address } from 'src/app/model/address';
import { Location } from '@angular/common';

@Component({
  selector: 'app-add-address',
  templateUrl: './add-address.component.html',
  styleUrls: ['./add-address.component.scss']
})
export class AddAddressComponent implements OnInit {

  form: FormGroup;
  city: Place[];
  address: Address = new Address();
 // cityString: String[];
 // filteredCity: Observable<String[]>;

 // cityString : String[] = this.city.
  
  constructor( private addressService : AddressService,
    private fb:FormBuilder,
    private snackBar: MatSnackBar,
    private location: Location) {

     this.form = fb.group({
       'street': [null],
       'number' :[null],
       'place': [null],
       'country' :[null]
     });
     }

  ngOnInit() {
      /*  
    this.addressService.getCity().subscribe(  data => {
      this.city = data.map(item =>{
          return{
            id: item.id,
            name: item.name,
            country: item.country,
          };
      })  })


this.filteredCity = this.form.valueChanges
      .pipe(
        startWith(''),
        map(value => this._filter(value))
      );
      */
  }


  onSubmit(){
    this.address.street = this.form.get("street").value;
    this.address.number = this.form.get("number").value;
    this.address.place.name = this.form.get("place").value;
    this.address.place.country.name = this.form.get("country").value;

    //console.log(this.address);
    this.addressService.addNewAddress(this.address).subscribe();
    this.openSnackBar("You have successfully added new address", "Close");
    this.goBack();
  }

  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 3000,
    });
  }


  
  goBack() {
    this.location.back();
  }
/*
  private _filter(value: String): String[] {
      //  this.city.forEach((x) => {
    //  this.cityString.push(Object.assign({}, x.name));
    const filterValue = value.toLowerCase();

    return this.cityString.filter(cityString => cityString.toLowerCase().includes(filterValue));
  }
  */
}
