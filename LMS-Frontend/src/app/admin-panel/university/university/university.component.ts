import { Component, OnInit } from '@angular/core';
import { UniversityService } from 'src/app/services/university-service/university.service';

@Component({
  selector: 'app-university',
  templateUrl: './university.component.html',
  styleUrls: ['./university.component.scss']
})


export class UniversityComponent implements OnInit {

  constructor(private service:UniversityService) { }

  ngOnInit() {
  }

}
