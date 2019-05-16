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

  private BASE_URL = "http://localhost:8080"
  private USER_URL = `${this.BASE_URL}\\users`;
  private STUDENT_URL = `${this.BASE_URL}\\students`;
  private CITIES_URL = `${this.BASE_URL}\\cities`
  private CHECK_USER_URL = `${this.BASE_URL}\\users\\check`;

  constructor(private http: HttpClient) { }

  addNewStudent(student: Student): Observable<any> {
    return this.http.post(this.STUDENT_URL, student);
  }

  addNewAdministration(admin: Admin): Observable<any> {
    return this.http.post(this.USER_URL, admin);
  }

  addNewTeacher(teacher: Teacher): Observable<any> {
    return this.http.post(this.USER_URL, teacher);
  }

  getAllUsers(): Observable<any> {
    return this.http.get(this.USER_URL);
  }

  // checkUser(user: User): Observable<any> {
  //   return this.http.post(this.CHECK_USER_URL, user);
  // }

  deleteUser(id: String) {
    return this.http.delete(this.USER_URL + `/${id}`);
  }

}
