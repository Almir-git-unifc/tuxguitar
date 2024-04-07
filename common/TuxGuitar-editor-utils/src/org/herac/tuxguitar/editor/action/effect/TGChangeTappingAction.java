package org.herac.tuxguitar.editor.action.effect;

import org.herac.tuxguitar.action.TGActionContext;
import org.herac.tuxguitar.document.TGDocumentContextAttributes;
import org.herac.tuxguitar.editor.action.TGActionBase;
import org.herac.tuxguitar.song.models.TGNote;
import org.herac.tuxguitar.song.models.TGString;
import org.herac.tuxguitar.song.models.TGTrack;
import org.herac.tuxguitar.util.TGContext;
import org.herac.tuxguitar.util.TGNoteRange;

public class TGChangeTappingAction extends TGActionBase {
	
	public static final String NAME = "action.note.effect.change-tapping";
	
	public static final String ATTRIBUTE_STRING = TGString.class.getName();
	
	public TGChangeTappingAction(TGContext context) {
		super(context, NAME);
	}
	
	protected void processAction(TGActionContext context){
		TGNoteRange noteRange = context.getAttribute(TGDocumentContextAttributes.ATTRIBUTE_NOTE_RANGE);
		TGTrack track = context.getAttribute(TGDocumentContextAttributes.ATTRIBUTE_TRACK);

		if (noteRange!=null && !noteRange.isEmpty() && !track.isPercussion()) {
			boolean newValue = true;
			if (noteRange.getNotes().stream().allMatch(n -> n.getEffect().isTapping())) {
				newValue = false;
			}
			for (TGNote note : noteRange.getNotes()) {
				getSongManager(context).getMeasureManager().setTapping(note, newValue);
			}
		}
	}
}
