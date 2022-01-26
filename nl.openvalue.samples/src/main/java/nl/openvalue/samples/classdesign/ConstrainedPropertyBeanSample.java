package nl.openvalue.samples.classdesign;

import java.beans.*;
import java.io.Serializable;

public class ConstrainedPropertyBeanSample {

    public static class Persoon implements Serializable {
        private String naam;
        private int leeftijd;
        private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
        private VetoableChangeSupport vetoableChangeSupport = new VetoableChangeSupport(this);

        public String getNaam() {
            return naam;
        }

        public void setNaam(String naam) throws PropertyVetoException {
            vetoableChangeSupport.fireVetoableChange("naam", this.naam, naam);
            changeSupport.firePropertyChange("naam", this.naam, naam);
            this.naam = naam;
        }

        public int getLeeftijd() {
            return leeftijd;
        }

        public void setLeeftijd(int leeftijd) throws PropertyVetoException {
            vetoableChangeSupport.fireVetoableChange("leeftijd", this.leeftijd, leeftijd);
            changeSupport.firePropertyChange("leeftijd", this.leeftijd, leeftijd);
            this.leeftijd = leeftijd;
        }

        public void addPropertyChangeListener(PropertyChangeListener listener) {
            changeSupport.addPropertyChangeListener(listener);
        }

        public void removePropertyChangeListener(PropertyChangeListener listener) {
            changeSupport.removePropertyChangeListener(listener);
        }

        public void addVetoableChangeListener(VetoableChangeListener listener) {
            vetoableChangeSupport.addVetoableChangeListener(listener);
        }

        public void removeVetoableChangeListener(VetoableChangeListener listener) {
            vetoableChangeSupport.removeVetoableChangeListener(listener);
        }
    }

    public static void main(String[] args) throws PropertyVetoException {
        Persoon p = new Persoon();
        p.addVetoableChangeListener(evt -> {
            if (evt.getPropertyName().equals("naam")) {
                if (((String) evt.getNewValue()).isEmpty()) {
                    throw new PropertyVetoException("naam can't be empty", evt);
                }
            } else if (evt.getPropertyName().equals("leeftijd")) {
                if ((int) evt.getNewValue() < 0) {
                    throw new PropertyVetoException("leeftijd can't be below 0", evt);
                }
            }
        });
        p.addPropertyChangeListener(evt -> {
            if (evt.getPropertyName().equals("naam")) {
                System.out.printf("old naam: %s, new naam: %s\n", evt.getOldValue(), evt.getNewValue());
            } else if (evt.getPropertyName().equals("leeftijd")) {
                System.out.printf("old leeftijd: %d, new leeftijd: %d\n", (int) evt.getOldValue(), (int) evt.getNewValue());
            } else {
                System.out.println("PropertyChangeEvent name is unknown: " + evt.getPropertyName());
            }
        });

        p.setLeeftijd(28);
        p.setNaam("Bryan");
        p.setLeeftijd(-1);
    }
}
