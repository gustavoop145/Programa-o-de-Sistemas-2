import React, { useEffect, useState } from 'react';
import api from '../services/api';

function VagasList() {
  const [vagas, setVagas] = useState([]);

  useEffect(() => {
    api.get('/vagas').then((response) => {
      setVagas(response.data);
    });
  }, []);

  return (
    <div>
      <h1>Vagas Abertas</h1>
      <ul>
        {vagas.map((vaga) => (
          <li key={vaga.id}>
            {vaga.titulo} - {vaga.area}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default VagasList;
