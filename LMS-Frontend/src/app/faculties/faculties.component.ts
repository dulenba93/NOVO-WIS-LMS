import { Component, OnInit, ViewChild, ElementRef, Input } from '@angular/core';
import { Faculty } from '../model/faculty';
import { FacultyService } from '../services/faculty-service/faculty.service';
import { UniversityService } from '../services/university-service/university.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-faculties',
  templateUrl: './faculties.component.html',
  styleUrls: ['./faculties.component.scss']
})
export class FacultiesComponent implements OnInit {

  @Input() universityId: string;

  latitude = 45.253217;
  longitude = 19.844015;

  faculties: Faculty[];

  constructor(
    private facultyService: FacultyService,
    private universityService: UniversityService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {

   
    this.route.paramMap.subscribe(
      params =>{

        // ovo + znaci kastovanje broj
        let id = +params.get('universityId');
       this.getFacultiesByUniversityId(id);

      }
    )

  
  }

  getFacultiesByUniversityId(id:number){
    //kada je id = 0 tj ne postoji to ce biti putanja za sve fakultete svih univerziteta
    if(id == 0){
      this.getFaculties();
    }else{
    this.facultyService.getFacultiesByUnivesityId(id).subscribe(faculties => this.faculties = faculties)
    }
  }

  getFaculties(): void {
    this.facultyService.getFaculties()
      .subscribe(faculties => this.faculties = faculties);
  }

}
