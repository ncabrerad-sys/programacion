import javax.swing.*
import java.awt.*
import kotlin.random.Random

class Clima : JFrame() {

    private val txtCiudad = JTextField()
    private val btnConsultar = JButton("Consultar Clima")

    private val lblInfo = JLabel("Consulta el clima actual de tu ciudad")
    private val lblCiudad = JLabel("Ciudad: -")
    private val lblTemp = JLabel("Temperatura: -")
    private val lblEstado = JLabel("Estado: -")
    private val lblHumedad = JLabel("Humedad: -")
    private val lblAmanecer = JLabel("Amanecer: -")
    private val lblAtardecer = JLabel("Atardecer: -")

    private val panel = JPanel()

    init {
        title = "Clima"
        setSize(450, 380)
        defaultCloseOperation = EXIT_ON_CLOSE
        setLocationRelativeTo(null)

        panel.layout = null
        panel.background = Color(25, 35, 65)
        add(panel)

        val titulo = JLabel("App del Clima")
        titulo.font = Font("Segoe UI", Font.BOLD, 22)
        titulo.foreground = Color.WHITE
        titulo.setBounds(130, 10, 200, 30)
        panel.add(titulo)

        lblInfo.font = Font("Segoe UI", Font.PLAIN, 12)
        lblInfo.foreground = Color.LIGHT_GRAY
        lblInfo.setBounds(100, 40, 300, 20)
        panel.add(lblInfo)

        val lblInput = JLabel("Ingrese ciudad:")
        lblInput.foreground = Color.WHITE
        lblInput.setBounds(40, 80, 120, 20)
        panel.add(lblInput)

        txtCiudad.setBounds(160, 80, 200, 30)
        txtCiudad.font = Font("Segoe UI", Font.PLAIN, 14)
        txtCiudad.border = BorderFactory.createEmptyBorder(5,10,5,10)
        panel.add(txtCiudad)

        btnConsultar.setBounds(140, 120, 160, 35)
        btnConsultar.background = Color(0, 140, 255)
        btnConsultar.foreground = Color.WHITE
        btnConsultar.font = Font("Segoe UI", Font.BOLD, 14)
        btnConsultar.isFocusPainted = false
        btnConsultar.border = BorderFactory.createEmptyBorder()
        panel.add(btnConsultar)

        // RESULTADOS
        lblCiudad.setBounds(40, 170, 300, 20)
        lblTemp.setBounds(40, 200, 300, 20)
        lblEstado.setBounds(40, 230, 300, 20)
        lblHumedad.setBounds(40, 260, 300, 20)
        lblAmanecer.setBounds(40, 290, 300, 20)
        lblAtardecer.setBounds(40, 320, 300, 20)

        val labels = listOf(lblCiudad, lblTemp, lblEstado, lblHumedad, lblAmanecer, lblAtardecer)

        for (l in labels) {
            l.foreground = Color.WHITE
            l.font = Font("Segoe UI", Font.PLAIN, 14)
            panel.add(l)
        }

        btnConsultar.addActionListener {
            consultarClima()
        }
    }

    private fun consultarClima() {
        val ciudad = txtCiudad.text

        if (ciudad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "⚠️ Ingresa una ciudad")
            return
        }

        val temperatura = Random.nextInt(10, 35)
        val humedad = Random.nextInt(40, 100)

        val estados = listOf("Soleado", "Nublado", "Lluvioso")
        val estado = estados.random()

        val amanecer = "${Random.nextInt(5,7)}:${Random.nextInt(0,59).toString().padStart(2,'0')} AM"
        val atardecer = "${Random.nextInt(5,7)}:${Random.nextInt(0,59).toString().padStart(2,'0')} PM"

        lblCiudad.text = "Ciudad: $ciudad"
        lblTemp.text = "Temperatura: $temperatura °C"
        lblEstado.text = "Estado: $estado"
        lblHumedad.text = "Humedad: $humedad %"
        lblAmanecer.text = "Amanecer: $amanecer"
        lblAtardecer.text = "Atardecer: $atardecer"

        when (estado) {
            "Soleado" -> panel.background = Color(255, 170, 50)
            "Nublado" -> panel.background = Color(120, 130, 150)
            "Lluvioso" -> panel.background = Color(50, 100, 200)
        }
    }
}
