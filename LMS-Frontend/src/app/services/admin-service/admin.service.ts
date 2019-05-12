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
  private CHECK_USER_URL = `${this.BASE_URL}\\users\\check`

  constructor(private http: HttpClient) { }

  addNewUser(user: User):Observable<any>{
   return this.http.post(this.USER_URL, user);
  }

  getAllUsers(): Observable<any>{
    return this.http.get(this.USER_URL);
  }

  checkUser(user: User): Observable<any>{
    return this.http.post(this.CHECK_USER_URL, user);
  }

  deleteUser(id:String){
    return this.http.delete(this.USER_URL + `/${id}`);
  }
  
}
