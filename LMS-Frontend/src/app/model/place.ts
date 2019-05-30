import { Country } from './country';

export class Place{
    id: number;
    name: String;
    country: Country = new Country();
}

export class PlaceDto{
    id: number;
    name: String;
    countryDto: Country = new Country();
}