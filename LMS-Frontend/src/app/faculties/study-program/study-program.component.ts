import { Component, OnInit } from '@angular/core';
import { FacultyService } from 'src/app/services/faculty-service/faculty.service';
import { StudyProgram } from 'src/app/model/studyProgram';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-study-program',
  templateUrl: './study-program.component.html',
  styleUrls: ['./study-program.component.scss']
})
export class StudyProgramComponent implements OnInit {

  studyProgram: StudyProgram[];
  constructor( private facultyService : FacultyService,
               private route: ActivatedRoute) { }

  ngOnInit() {

    this.route.paramMap.subscribe(
      params =>{

        // ovo + znaci kastovanje broj - ovaj facultyId gleda iz route-module
        let id = +params.get('facultyId');
       this.getStudyProgramByFacultyId(id);

      })
  }

  getStudyPrograms(): void {
    this.facultyService.getAllStudyProgram()
      .subscribe(studyProgram => {
        this.studyProgram = studyProgram
        console.log(this.studyProgram)
      }
      );
  }

  getStudyProgramByFacultyId(id: number){

    if(id == 0){
      this.getStudyPrograms();
    }else{
    this.facultyService.getStudyProgramByFacultyId(id).subscribe(data => this.studyProgram = data)
    }
  }

}
