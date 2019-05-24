import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import { Address } from '../../model/address';
@Injectable({
  providedIn: 'root'
})
export class AddressService {

  private BASE_URL = "http://localhost:8080";
  private ADDRESS_URL = `${this.BASE_URL}\\address`;

  constructor(
    private http: HttpClient
  ) { }

  addAddress(address: Address):Observable<any>{
    console.log(JSON.stringify(address))
    return this.http.post(this.ADDRESS_URL, address);
  } 

  getPlaces(): Observable<Address[]>{
    return this.http.get<Address[]>(this.ADDRESS_URL);
  }
}
