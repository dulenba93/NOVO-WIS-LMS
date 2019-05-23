import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { Faculty } from '../model/faculty';
import { FacultyService } from '../services/faculty-service/faculty.service';

@Component({
  selector: 'app-faculties',
  templateUrl: './faculties.component.html',
  styleUrls: ['./faculties.component.scss']
})
export class FacultiesComponent implements OnInit {

  latitude = 45.253217;
  longitude = 19.844015;

  faculties: Faculty[];

  constructor(
    private facultyService: FacultyService
  ) { }

  ngOnInit() {

    this.getFaculties();
  }

  getFaculties(): void {
    this.facultyService.getFaculties()
      .subscribe(faculties => this.faculties = faculties);
  }

}
