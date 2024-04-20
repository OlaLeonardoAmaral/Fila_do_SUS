
export interface PatientDTO {
    name: string,
    age: number,
    cpf: string,
    gender: string,
    hospital: {
        name: string
    }
}