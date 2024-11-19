package org.example;

import java.util.ArrayList;
import java.util.List;

public class ExampleService {

	private RadioChannel createRadioChannel() {
		return new RadioChannel();
	}

	public ArrayList<RadioChannel> compilationFails(List<StationNode> nodes) {
		ArrayList<RadioChannel> channels = new ArrayList<>(6);
		for (StationNode node : nodes) {
			var entryName = node.getPath();
			RadioChannel channel = switch (entryName) {
			case "A", "B" -> createRadioChannel();
			case "C", "D" -> createRadioChannel();
			default -> null;
			};
			if (channel != null) {
				channels.add(channel);
			}
		}
		return channels;
	}

	public ArrayList<RadioChannel> compilationOk1(List<StationNode> nodes) {
		ArrayList<RadioChannel> channels = new ArrayList<>(6);
		for (StationNode node : nodes) {
			var entryName = node.getPath();
			RadioChannel channel = switch (entryName) {
			case "A", "B" -> new RadioChannel();
			case "C", "D" -> new RadioChannel();
			default -> null;
			};
			if (channel != null) {
				channels.add(channel);
			}
		}
		return channels;
	}
	
	public ArrayList<RadioChannel> compilesOk2(List<StationNode> nodes) {
		ArrayList<RadioChannel> channels = new ArrayList<>(6);
		for (StationNode node : nodes) {
			var entryName = node.getPath();
			
			RadioChannel channel;
			switch(entryName) {
			case "A":
			case "B":
				channel = createRadioChannel();
				break;
			case "C":
			case "D":
				channel = createRadioChannel();
				break;
			default:
				channel = null;
			}
			if (channel != null) {
				channels.add(channel);
			}
		}
		return channels;
	}

}
