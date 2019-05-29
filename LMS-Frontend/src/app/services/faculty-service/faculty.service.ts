import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import { Faculty } from '../../model/faculty';

@Injectable({
  providedIn: 'root'
})
export class FacultyService {

  private facultyUrl = "http://localhost:8080/faculty"
  private FACULTY_BY_UNIVERSITY = "http://localhost:8080/faculty/universityid?id="

  constructor(
    private http: HttpClient
  ) { }

  getFaculties(): Observable<Faculty[]>{
    return this.http.get<Faculty[]>(this.facultyUrl);
  }

  getFacultiesByUnivesityId(id:number): Observable<Faculty[]>{
    return this.http.get<Faculty[]>(this.FACULTY_BY_UNIVERSITY + `${id}`);
  }

  addNewFaculty(faculty: Faculty): Observable<any>{
    return this.http.post(this.facultyUrl,faculty)
  }
}
