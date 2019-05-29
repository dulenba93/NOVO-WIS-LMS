import { Place } from './place';

export class Address{
    id: number;
    street: String;
    number: String;
    placeDto: Place = new Place();
}