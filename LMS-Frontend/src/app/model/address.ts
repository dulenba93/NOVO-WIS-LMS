import { Place, PlaceDto } from './place';

export class Address{
    id: number;
    street: String;
    number: String;
    place: Place = new Place();
}

export class AddressDto{
    id: number;
    street: String;
    number: String;
    placeDto: PlaceDto = new PlaceDto();
}