import { User } from './login';
export class UsersInfo {

  constructor(
    public count: number,
    public message: string,
    public users: User[],
  ) {}

}

