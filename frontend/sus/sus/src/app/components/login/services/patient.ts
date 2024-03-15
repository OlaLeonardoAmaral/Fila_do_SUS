
export interface Patient {
    pacienteId: number,
    nome: string,
    idade: number,
    cpf: string,
    sexo: string,
    status: string,
    hospital: {
        hospitalId: number
    }
}