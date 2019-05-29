import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Address } from 'src/app/model/address';
import { University } from 'src/app/model/university';
import { runInThisContext } from 'vm';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UniversityService {

  private BASE_URL = "http://localhost:8080";
  private UNIVERSITY_URL = "http://localhost:8080\\university";
  private ADDRESS_URL = `${this.BASE_URL}\\address`;

 // addressList: List<any>;
  constructor(private http: HttpClient) { }



  
  getAllAddress():Observable<Address[]>{
    return this.http.get<Address[]>(this.ADDRESS_URL);
  }

  addNewUniversity(university: University): Observable<any>{
    return this.http.post(this.UNIVERSITY_URL, university);
  }

  getAllUniversities(): Observable<University[]>{
    return this.http.get<any[]>(this.UNIVERSITY_URL);
  }



}
