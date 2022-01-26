package nl.openvalue.samples.classdesign;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class BoundedPropertyBeanSample {

    public static class Persoon implements Serializable {
        private String naam;
        private int leeftijd;
        private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

        public String getNaam() {
            return naam;
        }

        public void setNaam(String naam) {
            changeSupport.firePropertyChange("naam", this.naam, naam);
            this.naam = naam;
        }

        public int getLeeftijd() {
            return leeftijd;
        }

        public void setLeeftijd(int leeftijd) {
            changeSupport.firePropertyChange("leeftijd", this.leeftijd, leeftijd);
            this.leeftijd = leeftijd;
        }

        public void addPropertyChangeListener(PropertyChangeListener listener) {
            changeSupport.addPropertyChangeListener(listener);
        }

        public void removePropertyChangeListener(PropertyChangeListener listener) {
            changeSupport.removePropertyChangeListener(listener);
        }
    }

    public static void main(String[] args) {
        Persoon p = new Persoon();
        p.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("naam")) {
                    System.out.printf("old naam: %s, new naam: %s\n", evt.getOldValue(), evt.getNewValue());
                } else if (evt.getPropertyName().equals("leeftijd")) {
                    System.out.printf("old leeftijd: %d, new leeftijd: %d\n", (int) evt.getOldValue(), (int) evt.getNewValue());
                } else {
                    System.out.println("PropertyChangeEvent name is unknown: " + evt.getPropertyName());
                }
            }
        });

        p.setLeeftijd(28);
        p.setNaam("Bryan");
    }
}
