/**
 * ***************************************************************************
 * Copyright (c) 2018 RiceFish Limited
 * Project: SmartMES
 * Version: 1.6
 *
 * This file is part of SmartMES.
 *
 * SmartMES is Authorized software; you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation; either version 3 of the License,
 * or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 * ***************************************************************************
 */
package com.qcadoo.mes.deliveries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.qcadoo.mes.deliveries.columnExtension.DeliveriesColumnLoader;
import com.qcadoo.plugin.api.Module;

@Component
public class DeliveriesOnStartupService extends Module {

    @Autowired
    private DeliveriesColumnLoader deliveriesColumnLoader;

    @Transactional
    @Override
    public void multiTenantEnable() {
        deliveriesColumnLoader.addColumnsForDeliveries();
        deliveriesColumnLoader.addColumnsForOrders();
    }

    @Transactional
    @Override
    public void multiTenantDisable() {
        deliveriesColumnLoader.deleteColumnsForDeliveries();
        deliveriesColumnLoader.deleteColumnsForOrders();
    }

}
