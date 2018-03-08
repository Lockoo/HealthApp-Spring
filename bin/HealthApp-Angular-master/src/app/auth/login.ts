export class Login {
  constructor(
    public email: string,
    public password: string
  ) {  }
}

export class NewUser {
  public role = 0;
  public email = '';
  public password = '';
  public firstName = '';
  public lastName = '';
  public speciality = '';
  constructor() {}
}

export class User {
  constructor(
    public firstName: string,
    public lastName: string,
    public email: string,
    public role: number,
    public speciality: string
  ) {}
}

export class SignupStatus {
  public code = '';
  public message = '';
  public user = new User('', '', '', 0, '');
  constructor() {}
}

export class LoginStatus {
  constructor(
    public code: string,
    public message: string,
    public user: User
  ) { }
}
