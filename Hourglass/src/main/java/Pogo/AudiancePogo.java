package Pogo;

import com.Project.Hourglass.model.enumeration.FatStorage;
import com.Project.Hourglass.model.enumeration.Frame;
import com.Project.Hourglass.model.enumeration.OverweightCause;
import com.Project.Hourglass.model.enumeration.Sex;
import com.Project.Hourglass.model.enumeration.Silhouette;

public class AudiancePogo {



	public AudiancePogo(Sex sex, float height, float objectiveWeight, Frame frame, FatStorage fatStorage,
			Silhouette silhouette, OverweightCause overWeightCause) {
		super();
		this.sex = sex;
		this.height = height;
		this.objectiveWeight = objectiveWeight;
		this.frame = frame;
		this.fatStorage = fatStorage;
		this.silhouette = silhouette;
		this.overWeightCause = overWeightCause;
	}
	public Sex  sex;
	public float height;
	public float  objectiveWeight;
	public Frame  frame;
	public FatStorage  fatStorage;
	public Silhouette  silhouette;
	public OverweightCause overWeightCause;

}
