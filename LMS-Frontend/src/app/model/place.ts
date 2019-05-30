import { Country } from './country';

export class Place{
    id: number;
    name: String;
    countryDto: Country = new Country();
}