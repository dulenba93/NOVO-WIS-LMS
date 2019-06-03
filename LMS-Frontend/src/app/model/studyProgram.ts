import { Faculty } from './faculty';

export class StudyProgram{
    id: number
    description: String
    name: String
    manager: String
    faculty: Faculty = new Faculty()
}