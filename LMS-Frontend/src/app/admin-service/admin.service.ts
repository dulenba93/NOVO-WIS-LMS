import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../user';
import { Observable } from 'rxjs';
import { Alert } from 'selenium-webdriver';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
}; 

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private BASE_URL = "http://localhost:8080"
  private USER_URL = `${this.BASE_URL}\\users`;
  private FIND_USERNAME_URL = "http://localhost:8080/users/findbyusername?user=";

  constructor(private http: HttpClient) { }

  checkUserExists(user: User): Observable<any>{
    var route = this.FIND_USERNAME_URL + user.username;
    return this.http.get(route);
  }

  addNewUser(user: User):Observable<any>{

   return this.http.post(this.USER_URL, user);
 
   
  }


}
