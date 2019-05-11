import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../../model/user'
import { Observable } from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
}; 

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private BASE_URL = "http://localhost:8080"
  private USER_URL = `${this.BASE_URL}\\users`;

  constructor(private http: HttpClient) { }

  addNewUser(user: User):Observable<any>{

   return this.http.post(this.USER_URL, user);  
  }

  getAllUsers():Observable<User[]>{
    
    return this.http.get<User[]>(this.USER_URL);
  }

  
}
