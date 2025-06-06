# Sistema de Gestión de Expedientes - Prototipo (TP3 - Seminario de Práctica Informática)

Este proyecto es un **prototipo funcional** desarrollado como parte del **TP3** de la asignatura Seminario de Práctica Informática. Simula el circuito de tramitación de expedientes administrativos en una municipalidad, incluyendo el registro de contribuyentes, la generación de expedientes y el control de los requisitos.

## Objetivo del trabajo

El objetivo es aplicar conceptos de programación orientada a objetos (POO) en Java, trabajando con encapsulamiento, herencia, polimorfismo y abstracción. También se implementan estructuras de datos, interfaces gráficas (Swing) y persistencia simple mediante archivos JSON.

## Estructura general del sistema

- **Clases**: `Expediente`, `Contribuyente`, `Rubro`, `TipoTramite`, `Usuario`, `Sector` y sus subclases (`MesaEntrada`, `Comercio`).
- **Persistencia**: Lectura/escritura de archivos JSON (`ExpedienteDAOJson`, `ContribuyenteDAOJson`).
- **Interfaz gráfica (Swing)**:
  - `MenuSectores` (menú principal del sistema)
  - `MenuMesaE` y `MenuComercio` (menús por sector)
  - `VentanaExpedienteMesaEntrada` (registro de expediente)
  - `VentanaExpedienteComercio` (verificación de requisitos)
  - `VentanaContribuyente` (registro y selección de contribuyentes)

## Características del prototipo

- Registro y modificación de **contribuyentes**
- Alta y edición de **expedientes** desde Mesa de Entrada
- Visualización de datos y checklist desde el sector Comercio
- Persistencia de datos en archivos `.json`
- Flujo de trabajo simplificado para mostrar el ciclo básico de vida del expediente


## Funcionalidades no implementadas aún

Algunas clases forman parte del diseño pero no están integradas en esta etapa:
- `Usuario`, `Movimiento`, `ActuacionSectorial`, `Requisito`
- `Rubro` y `TipoTramite` están presentes pero su lógica estática aún no se aplica

Estas se consideran para una etapa futura en la que se implemente seguridad, trazabilidad, y control de estados más avanzados.

## Cómo ejecutar el sistema

1. Abrir el proyecto en tu IDE Java 
2. Ejecutar la clase: MenuSectores
3. Desde allí se accede a los menús de Mesa de Entrada y Comercio.


## Capturas

Se incluyen en la carpeta `/tp3/capturas` las principales ventanas y un ejemplo completo del circuito de alta de expediente.

---

**Autor**: Gabriel Lattmann  
**Materia**: Seminario de Práctica Informática  
**Año**: 2025  


