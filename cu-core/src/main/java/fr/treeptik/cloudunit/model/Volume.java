package fr.treeptik.cloudunit.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Volume implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	public Volume() {

	}

	public Volume(Integer id, String name, Set<VolumeAssociation> volumeAssociations) {
		this.id = id;
		this.name = name;
		this.volumeAssociations = volumeAssociations;
	}

	@OneToMany(mappedBy = "volumeAssociationId.volume", fetch = FetchType.LAZY)
	private Set<VolumeAssociation> volumeAssociations;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<VolumeAssociation> getVolumeAssociations() {
		return volumeAssociations;
	}

	public void setVolumeAssociations(Set<VolumeAssociation> volumeAssociations) {
		this.volumeAssociations = volumeAssociations;
	}

	@Override
	public String toString() {
		return "Volume [id=" + id + ", name=" + name + "]";
	}

}
