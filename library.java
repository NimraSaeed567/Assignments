package projecttest;


	import java.util.ArrayList;
	import java.util.List;

	public class Library<T extends Media> {
	    private List<T> mediaItems;
	    private List<LibraryObserver> observers;

	    public Library() {
	        this.mediaItems = new ArrayList<>();
	        this.observers = new ArrayList<>();
	    }

	    public void addMediaItem(T mediaItem) {
	        mediaItems.add(mediaItem);
	        notifyObservers(new libraryevent("New Media Added", mediaItem.getClass().getSimpleName(), mediaItem.getTitle()));
	    }

	    public void updateMediaPrice(T mediaItem, double newPrice) {
	        mediaItem.updatePrice(newPrice);
	        notifyObservers(new libraryevent("Price Updated", mediaItem.getClass().getSimpleName(), mediaItem.getTitle()));
	    }

	    public void addObserver(LibraryObserver observer) {
	        observers.add(observer);
	    }

	    public void removeObserver(LibraryObserver observer) {
	        observers.remove(observer);
	    }

	    private void notifyObservers(libraryevent event) {
	        for (LibraryObserver observer : observers) {
	            observer.updateEvent(event);
	        }
	    }


	    public List<T> getMediaItems() {
	        return mediaItems;
	    }
	}
