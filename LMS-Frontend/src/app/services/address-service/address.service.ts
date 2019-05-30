import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import { Address, AddressDto } from '../../model/address';
import { Place } from 'src/app/model/place';
@Injectable({
  providedIn: 'root'
})
export class AddressService {

  private BASE_URL = "http://localhost:8080";
  private ADDRESS_URL = `${this.BASE_URL}\\address`;
  private PLACE_URL = `${this.BASE_URL}\\place`;

  constructor(
    private http: HttpClient
  ) { }

  addAddress(address: Address):Observable<any>{
    console.log(JSON.stringify(address))
    return this.http.post(this.ADDRESS_URL, address);
  } 

  addNewAddress(address: Address):Observable<any>{
    return this.http.post(this.ADDRESS_URL, address);
  } 

  //ovo ne znam sta je
  getPlaces(): Observable<Address[]>{
    return this.http.get<Address[]>(this.ADDRESS_URL);
  }

  getCity(): Observable<Place[]>{
    return this.http.get<Place[]>(this.PLACE_URL);
  }
}
