import { Component, OnInit } from '@angular/core';
import { Subject } from '../model/subject';
import { SubjectService } from '../services/subject-service/subject.service';

@Component({
  selector: 'app-materials-page',
  templateUrl: './materials-page.component.html',
  styleUrls: ['./materials-page.component.scss']
})
export class MaterialsPageComponent implements OnInit {

  subjects : Subject[];

  
  constructor(
    private subjectService: SubjectService
  ) { }

  ngOnInit() {
    this.getSubjects();
  }

  getSubjects(): void{
    this.subjectService.getSubjects()
    .subscribe(subjects => this.subjects = subjects);
  }
}
