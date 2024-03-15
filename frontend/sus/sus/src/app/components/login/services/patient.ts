
export interface Patient {
    name: string,
    age: number,
    cpf: string,
    gender: string,
    status: string,
    hospital: {
        hospitalId: number
    }
}