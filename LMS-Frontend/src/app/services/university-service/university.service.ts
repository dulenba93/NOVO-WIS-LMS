import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Address } from 'src/app/model/address';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UniversityService {

  private BASE_URL = "http://localhost:8080";
  private ADDRESS_URL = `${this.BASE_URL}\\address`;

 // addressList: List<any>;


  constructor(private http: HttpClient) { }



  
  getAllAddress():Observable<Address[]>{
    return this.http.get<Address[]>(this.ADDRESS_URL);
  }

}
