document.addEventListener('DOMContentLoaded', () => {
    // Datos simulados
    const registros = [
        { fecha: '2024-08-19', hora: '08:00', tipo: 'Entrada' },
        { fecha: '2024-08-19', hora: '17:00', tipo: 'Salida' }
    ];

    const mensaje = document.getElementById('mensaje');
    const fechaHora = document.getElementById('fechaHora');
    const historial = document.querySelector('#historial tbody');
    const marcarEntradaBtn = document.getElementById('marcarEntrada');
    const marcarSalidaBtn = document.getElementById('marcarSalida');

    // Función para actualizar el mensaje
    function actualizarMensaje() {
        if (registros.length === 0) {
            mensaje.textContent = 'Marcación de Entrada';
        } else {
            const ultimaMarcacion = registros[registros.length - 1];
            mensaje.textContent = ultimaMarcacion.tipo === 'Entrada' ? 'Marcación de Salida' : 'Marcación de Entrada';
        }
    }

    // Función para cargar el historial
    function cargarHistorial() {
        historial.innerHTML = ''; // Limpiar historial
        registros.forEach(registro => {
            const fila = document.createElement('tr');
            fila.innerHTML = `
                <td>${registro.fecha}</td>
                <td>${registro.hora}</td>
                <td>${registro.tipo}</td>
            `;
            historial.appendChild(fila);
        });
    }

    // Función para actualizar la fecha y hora
    function actualizarFechaHora() {
        const ahora = new Date();
        const opcionesFecha = { year: 'numeric', month: '2-digit', day: '2-digit' };
        const fecha = ahora.toLocaleDateString('es-ES', opcionesFecha);
        const opcionesHora = { hour: '2-digit', minute: '2-digit', second: '2-digit' };
        const hora = ahora.toLocaleTimeString('es-ES', opcionesHora);
        fechaHora.textContent = `${fecha} ${hora}`;
    }

    // Inicializar la página
    actualizarMensaje();
    cargarHistorial();
    actualizarFechaHora();

    // Actualizar la fecha y hora cada segundo
    setInterval(actualizarFechaHora, 1000);

    // Event listeners para botones
    marcarEntradaBtn.addEventListener('click', () => {
        const ahora = new Date();
        const nuevaMarcacion = {
            fecha: ahora.toISOString().split('T')[0],
            hora: ahora.toTimeString().split(' ')[0],
            tipo: 'Entrada'
        };
        registros.push(nuevaMarcacion);
        actualizarMensaje();
        cargarHistorial();
    });

    marcarSalidaBtn.addEventListener('click', () => {
        const ahora = new Date();
        const nuevaMarcacion = {
            fecha: ahora.toISOString().split('T')[0],
            hora: ahora.toTimeString().split(' ')[0],
            tipo: 'Salida'
        };
        registros.push(nuevaMarcacion);
        actualizarMensaje();
        cargarHistorial();
    });
});
