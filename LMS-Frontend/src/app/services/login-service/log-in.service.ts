import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LogInService {

  constructor(
    private http: HttpClient,
    private router: Router
  ) { }

  login(username: String, password: String){
    this.http.post<{token: string}>("url", {username: username, password: password}).subscribe(response =>{
      if(response.token){
        
      }
    })
  }
}
