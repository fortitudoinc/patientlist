/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.patientlist.api;

import java.util.List;
import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.patientlist.PatientListItem;
import org.openmrs.module.patientlist.PatientListItemConfig;
import org.springframework.transaction.annotation.Transactional;

/**
 * The main service of this module, which is exposed for other modules. See
 * moduleApplicationContext.xml on how it is wired up.
 */
@Transactional
public interface PatientListItemService extends OpenmrsService {
	
	/**
	 * Saves a patient list item. Sets the owner to superuser, if it is not set. It can be called by
	 * users with this module's privilege. It is executed in a transaction.
	 * 
	 * @param item
	 * @return
	 * @throws APIException
	 */
	@Authorized(PatientListItemConfig.MODULE_PRIVILEGE)
	@Transactional
	PatientListItem savePatientListItem(PatientListItem item) throws APIException;
	
	/**
	 * Get a {@link PatientListItem} object by primary key id.
	 * 
	 * @param id the primary key integer id to look up on
	 * @return the found PatientListItem object which matches the row with the given id. If no row
	 *         with the given id exists, null is returned.
	 */
	@Authorized()
	@Transactional(readOnly = true)
	public PatientListItem getPatientListItem(Integer id);
	
	@Authorized()
	@Transactional(readOnly = true)
	public List<PatientListItem> getActivePatientListItemForPatient(Integer patientId);
	
	@Authorized()
	@Transactional(readOnly = true)
	public List<PatientListItem> getActivePatientListItems();
	
	@Authorized()
	@Transactional(readOnly = true)
	public List<PatientListItem> getOldPatientListItems();
	
	@Authorized()
	@Transactional(readOnly = true)
	public List<PatientListItem> getAllPatientListItems();
	
}
