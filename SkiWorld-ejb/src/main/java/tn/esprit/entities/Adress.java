package tn.esprit.entities;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class Adress {
	
	private String country;
	@Size(min=3 , message="City must be at least of 3 length")
	private String city;
<<<<<<< Upstream, based on origin/master
	@Size(min=3,message="Adress must be at lest of 3 length")
	
=======
>>>>>>> 0bbfb85 Ahmed Commit
	private String adress;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	@Override
	public String toString() {
<<<<<<< Upstream, based on origin/master
		return "country:" + country + ", city:" + city + ", adress:" + adress;
=======
		return "Adress [country=" + country + ", city=" + city + ", adress=" + adress + "]";
>>>>>>> 0bbfb85 Ahmed Commit
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adress other = (Adress) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		return true;
	}
	public Adress(String country, String city, String adress) {
		super();
		this.country = country;
		this.city = city;
		this.adress = adress;
	}
<<<<<<< Upstream, based on origin/master
	public Adress() {
		super();
	}
=======
>>>>>>> 0bbfb85 Ahmed Commit
	
	
<<<<<<< Upstream, based on origin/master
	
=======
>>>>>>> 0bbfb85 Ahmed Commit
}
