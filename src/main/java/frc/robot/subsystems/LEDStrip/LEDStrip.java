// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.LEDStrip;

/** Add your docs here. */
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.LEDPanel.Letters.Phrases;

public class LEDStrip extends SubsystemBase {
    private AddressableLED m_led = null;
    private AddressableLEDBuffer m_ledBuffer = null;
    private final int kLED_COLUMNS = 32;
    private final int kLED_ROWS = 1;
    // number of LEDs
    private final int m_noLEDs = kLED_ROWS * kLED_COLUMNS;

    /** Creates a new LEDPanel. */
    public LEDStrip() {

        // PWM port 7
        // Must be a PWM header, not MXP or DIO
        m_led = new AddressableLED(7);

        // Reuse buffer
        // Default to a length the size of LED Panel, start empty output
        // Length is expensive to set, so only set it once, then just update data
        m_ledBuffer = new AddressableLEDBuffer(m_noLEDs);
        m_led.setLength(m_ledBuffer.getLength());

        // Red: (255, 0, 0)
        // White: (255, 255, 255)
        // Green:(0, 128, 0)
        // Yellow:(255, 255, 0)

        // Set the data
        // m_ledBuffer.setRGB(5, 255, 0, 0);
        String currentColor = "white";
        String newColor = "white";
        for (var i = 0; i < m_ledBuffer.getLength(); i++) {
            // Sets the specified LED to the RGB values for red
            if ((i % 2) == 0) {
                if (newColor == "white") {
                    m_ledBuffer.setRGB(i, 255, 255, 255);
                } else {
                    m_ledBuffer.setRGB(i, 0, 255, 0);
                }
            }

        }
        m_led.setData(m_ledBuffer);
        m_led.start();

        // m_timer.start();
    }

}
