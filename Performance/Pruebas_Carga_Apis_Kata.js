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
    _token: 'e368bf7a0f9225b25569ad632354b.XNcvcCPVbIlHb82kvgkXZj7U2540aozRtu1lrKujskE.HZ1jPkq8DtYhFeDz6059IG2No_ZTGv6SgLJT9unJ9zgd71wiFKYf8HIh_Q',
    username: 'Admin',
    password: 'admin123',
  };

  const params = {
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded',
      'Cookie': 'orangehrm=lgh92uiaqsv17r0pbu8k0fqmlb; orangehrm=93a3dp6bh5v96nfonel41jco0j',
    },
  };


  const res = http.post(url, payload, params);


  check(res, {
    'status es 200': (r) => r.status === 200,
    'respuesta contiene "success" o redirección': (r) =>
      r.body.includes('dashboard') || r.status === 302,
  });

  sleep(1);
}
export function handleSummary(data) {
  return {
    'html-report.html': htmlReport(data), // Genera el informe HTML
    'summary.json': JSON.stringify(data, null, 2), // Opcional: también puedes generar un JSON
  };
}
