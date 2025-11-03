import http from 'k6/http';
import { check, sleep } from 'k6';
import { htmlReport } from "https://raw.githubusercontent.com/benc-uk/k6-reporter/main/dist/bundle.js";


export const options = {
  stages: [
    { duration: '30s', target: 50 }, // Subida de usuarios
    { duration: '4m', target: 50 },  // Mantiene carga estable
    { duration: '30s', target: 0 },  // Bajada gradual
  ],
};


export default function () {
  const url = 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/validate';

  const payload = {
    _token: '027ff75bb950e3a899.sdeSEMHOnFyAuUjsdnDKj6qpOm154vKIVa8yj8CwKN8.25TYV62N1y7j6BqBQzHytuidSScYqJPtMpoEv6HocYXz5_dPgI3sCreOGQ',
    username: 'Admin',
    password: 'admin123',
  };

  const params = {
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded',
      'Cookie': 'orangehrm=budu9h5r3s5d7bmncphmid2n7k',
    },
  };


  const res = http.post(url, payload, params);


  check(res, {
    'status es 200': (r) => r.status === 200,
    'respuesta contiene "OK"': (r) =>
      r.body.includes('dashboard') || r.status === 200,
  });

  sleep(1);
}
export function handleSummary(data) {
  return {
    'html-report.html': htmlReport(data), // Genera el informe HTML
    'summary.json': JSON.stringify(data, null, 2), // Opcional: también puedes generar un JSON
  };
}