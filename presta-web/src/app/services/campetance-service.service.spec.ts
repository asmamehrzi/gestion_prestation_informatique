import { TestBed } from '@angular/core/testing';

import { CampetanceServiceService } from './campetance-service.service';

describe('CampetanceServiceService', () => {
  let service: CampetanceServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CampetanceServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
