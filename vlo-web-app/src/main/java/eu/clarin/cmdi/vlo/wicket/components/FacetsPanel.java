/*
 * Copyright (C) 2014 CLARIN
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package eu.clarin.cmdi.vlo.wicket.components;

import eu.clarin.cmdi.vlo.pojo.QueryFacetsSelection;
import eu.clarin.cmdi.vlo.wicket.model.FacetSelectionModel;
import java.util.List;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * A panel representing a group of facets.
 *
 * For each facet present in the provided list model, a {@link FacetPanel} is
 * added to the a list view.
 *
 * @author twagoo
 */
public class FacetsPanel extends Panel {

    /**
     *
     * @param id component id
     * @param facetsModel model that provides the list of facets to show in this
     * panel
     * @param selectionModel model representing the current query/value
     * selection state
     */
    public FacetsPanel(final String id, final IModel<List<FacetField>> facetsModel, final IModel<QueryFacetsSelection> selectionModel) {
        super(id, selectionModel);

        add(new ListView<FacetField>("facets", facetsModel) {

            @Override
            protected void populateItem(ListItem<FacetField> item) {
                item.add(
                        new FacetPanel("facet", new FacetSelectionModel(item.getModel(), selectionModel))
                );
            }
        });
    }
}
