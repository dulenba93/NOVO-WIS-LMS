import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import { Faculty } from '../../model/faculty';

@Injectable({
  providedIn: 'root'
})
export class FacultyService {

  private facultyUrl = "http://localhost:8080/faculty"

  constructor(
    private http: HttpClient
  ) { }

  getFaculties(): Observable<Faculty[]>{
    return this.http.get<Faculty[]>(this.facultyUrl);
  }

  addNewFaculty(faculty: Faculty): Observable<any>{
    return this.http.post(this.facultyUrl,faculty)
  }
}
