export class Doctor
{
  constructor(
    public id: number,
    public firstName: string,
    public lastName: string,
    public email: string,
    public speciality: string
  ) {}

}

export class UpdatedDoc
{
  constructor(
    public doc: Doctor,
    public firstName: string) {}
}
