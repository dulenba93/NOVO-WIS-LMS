import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import { Place } from '../../model/place';
@Injectable({
  providedIn: 'root'
})
export class PlaceService {

  private placeUrl= "http://localhost:8080/place/"

  constructor(
    private http: HttpClient
  ) { }

  getPlaces(): Observable<Place[]>{
    return this.http.get<Place[]>(this.placeUrl);
  }
}
