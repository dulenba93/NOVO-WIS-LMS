import { University } from './university';
import { Address } from './address';

export class Faculty{
    id: number
    description: String
    name: String
    dean: String
    address: Address = new Address()
    university: University = new University()
}