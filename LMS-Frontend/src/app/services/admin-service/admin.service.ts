import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Student } from 'src/app/model/student';
import { Admin } from 'src/app/model/admin';
import { Teacher } from 'src/app/model/teacher';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private BASE_URL = "http://localhost:8080";
  private USER_URL = `${this.BASE_URL}\\users`;
  private STUDENT_URL = `${this.BASE_URL}\\students`;
  private ADMINISTRATOR_URL = `${this.BASE_URL}\\administrative`;
  private TEACHER_URL = `${this.BASE_URL}\\teacher`;
  private CITIES_URL = `${this.BASE_URL}\\cities`
  private CHECK_USER_URL = `${this.BASE_URL}\\users\\check`;
  private ADDRESS_URL = `${this.BASE_URL}\\address`;

  constructor(private http: HttpClient) { }

  addNewStudent(student: Student): Observable<any> {
    return this.http.post(this.STUDENT_URL, student);
  }

  addNewAdministration(admin: Admin): Observable<any> {
    return this.http.post(this.ADMINISTRATOR_URL, admin);
  }

  addNewTeacher(teacher: Teacher): Observable<any> {
    return this.http.post(this.TEACHER_URL, teacher);
  }

  deleteUser(id: String) {
    return this.http.delete(this.USER_URL + `/${id}`);
  }

}
