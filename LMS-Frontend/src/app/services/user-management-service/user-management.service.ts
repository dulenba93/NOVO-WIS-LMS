import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserManagementService {

  private BASE_URL = "http://localhost:8080";
  private STUDENT_URL = `${this.BASE_URL}\\students`;
  private ADMINISTRATOR_URL = `${this.BASE_URL}\\administrative`;
  private TEACHER_URL = `${this.BASE_URL}\\teacher`;
  
  constructor(private http: HttpClient) { }

  getAllStudents(): Observable<any>{
    return this.http.get(this.STUDENT_URL);
  }
}
