
export interface PatientDTO {
    patientId: number,
    name: string,
    age: number,
    cpf: string,
    gender: string,
    hospital: {
        hospitalId: number
    }
}